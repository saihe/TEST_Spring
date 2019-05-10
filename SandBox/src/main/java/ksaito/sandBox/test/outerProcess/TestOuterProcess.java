package ksaito.sandBox.test.outerProcess;

import ksaito.sandBox.BaseClass;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOuterProcess extends BaseClass {
    public enum MODE {
        OLD, NEW;
    }
    public void run() {
        oldProcess();
    }
    public void run(MODE mode) {
        switch(mode) {
            case OLD:
                oldProcess();
                break;
            case NEW:
                newProcess();
                break;
            default:
                break;
        }
    }

    public void newProcess() {
        String[] command = new String[]{"C:/work/test/lib/test.bat"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        pb.inheritIO();
        pb.directory(Paths.get("C:/work/test/lib/").toFile());
        try {
            print(pb.command());
            Process p = pb.start();
            print(pb.directory().getPath());
            boolean isFinished = p.waitFor(1, TimeUnit.SECONDS);

            if(isFinished) {
                print("正常終了");
            } else {
                print("タイムアウト");
                p = p.destroyForcibly();
                print(String.valueOf(p.exitValue()));
                System.exit(1);
            }
            print(String.valueOf(p.exitValue()));

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void oldProcess() {
        String[] command = new String[]{"C:/work/test/lib/test.bat"};
        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            print(pb.command());
            Process p = pb.start();
            InputStreamThread it = new InputStreamThread(p.getInputStream(), StandardCharsets.ISO_8859_1.displayName());
            InputStreamThread et = new InputStreamThread(p.getErrorStream(), StandardCharsets.ISO_8859_1.displayName());
            it.start();
            et.start();
            boolean isFinished = p.waitFor(1, TimeUnit.SECONDS);
            it.join();
            et.join();

            for (String s : it.getStringList()) {
                print(s);
            }
            //標準エラーの内容を出力
            for (String s : et.getStringList()) {
                print(s);
            }
            if(isFinished) {
                print("正常終了");
            } else {
                print("タイムアウト");
                p.destroy();
                print(String.valueOf(p.exitValue()));
                System.exit(1);
            }
            print(String.valueOf(p.exitValue()));

        } catch(Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * InputStreamを読み込むスレッド
     */
    public class InputStreamThread extends Thread {

        private BufferedReader br;

        private List<String> list = new ArrayList<String>();

        /** コンストラクター */
        public InputStreamThread(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        /** コンストラクター */
        public InputStreamThread(InputStream is, String charset) {
            try {
                br = new BufferedReader(new InputStreamReader(is, charset));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            try {
                for (;;) {
                    String line = br.readLine();
                    if (line == null) 	break;
                    list.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /** 文字列取得 */
        public List<String> getStringList() {
            return list;
        }
    }}
