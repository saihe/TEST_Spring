package ksaito.sandBox.test.innerClass;

import ksaito.sandBox.BaseClass;

public class TestInnerClass extends BaseClass {
    private String memberBasePrivate = "Private base member.";
    public String memberBasePublic = "Public base member.";

    public String getMemberBasePrivate() {
        return memberBasePrivate;
    }
    public String getMemberBasePublic() {
        return memberBasePublic;
    }
    public String[] getMembers() {
        return new String[]{this.memberBasePublic,this.memberBasePrivate};
    }
    public void run() {
        TestInnerClass innerClass = new TestInnerClass();
        InnerClassPublic innerClassPublic = new InnerClassPublic();
        InnerClassPrivate innerClassPrivate = new InnerClassPrivate();
        print(innerClass.getMembers());
        print(innerClassPublic.getMembers());
        print(innerClassPrivate.getMembers());
    }
    private class InnerClassPrivate {
        private String memberInnerPrivate = "Private inner member.";
        public String memberInnerPublic = "Public inner member.";

        public String getMemberInnerPrivate() {
            return this.memberInnerPrivate;
        }
        public String getMemberInnerPublic() {
            return this.memberInnerPublic;
        }
        public String[] getMembers() {
            return new String[]{this.memberInnerPrivate,this.memberInnerPublic};
        }
    }
    public class InnerClassPublic {
        private String memberInnerPrivate = "Private inner member.";
        public String memberInnerPublic = "Public inner member.";

        public String getMemberInnerPrivate() {
            return this.memberInnerPrivate;
        }
        public String getMemberInnerPublic() {
            return this.memberInnerPublic;
        }
        public String[] getMembers() {
            return new String[]{this.memberInnerPrivate,this.memberInnerPublic};
        }
    }
}
