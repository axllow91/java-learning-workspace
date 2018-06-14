package inheritance.oop2;

import inheritance.oop1.A1;

public class B2 {
    public static void main(String[] args) {
        //System.out.println("A1.privateMember: " + A1.privateMember);
        //System.out.println("A1.defaultMember: " + A1.defaultMember);

        //System.out.println("A1.protectedMember: " + A1.protectedMember);
        //System.out.println("C2.protectedMember: " + C2.protectedMember);

        System.out.println("A1.publicMember: " + A1.publicMember);
        System.out.println("C2.publicMember: " + C2.publicMember); // works because c2 extends class a1
        // so only the public members will be accessible

    }
}
