package Utilities;

public class EmailPermutaions {

    public static void main(String[] args) {

//        emailCombinations("Aditya","Naik","Oracle");
        emailCombinations("Aditya","shashikant","Naik","Oracle");

    }

    private static void emailCombinations(String firstName, String middleName, String lastName, String companyName) {

//        first.middle.last@example.com (e.g., john.m.doe@example.com)
        System.out.println(firstName+"."+ middleName.charAt(0)+"."+lastName+"@"+companyName+".com");
//        firstlastmiddle@example.com (e.g., johnmdoe@example.com)
        System.out.println(firstName+""+ middleName.charAt(0)+""+lastName+"@"+companyName+".com");
//        first.middlelast@example.com (e.g., john.mdoe@example.com)
        System.out.println(firstName+"."+ middleName.charAt(0)+""+lastName+"@"+companyName+".com");
//        f.middle.last@example.com (e.g., j.m.doe@example.com)
        System.out.println(firstName.charAt(0)+"."+ middleName.charAt(0)+"."+lastName+"@"+companyName+".com");
//        f.middlelast@example.com (e.g., j.mdoe@example.com)
        System.out.println(firstName.charAt(0)+"."+ middleName.charAt(0)+""+lastName+"@"+companyName+".com");
    }

    private static void emailCombinations(String firstName, String lastName, String companyName) {

//    first.last@example.com (e.g., john.doe@example.com)
        System.out.println(firstName+"."+lastName+"@"+companyName+".com");
//    firstlast@example.com (e.g., johndoe@example.com)
        System.out.println(firstName+""+lastName+"@"+companyName+".com");
//    first_last@example.com (e.g., john_doe@example.com)
        System.out.println(firstName+"_"+lastName+"@"+companyName+".com");
//    firstl@example.com (e.g., john.d@example.com)
        System.out.println(firstName+"."+lastName.charAt(0)+"@"+companyName+".com");
//    f.last@example.com (e.g., j.doe@example.com)
        System.out.println(firstName.charAt(0)+"."+lastName+"@"+companyName+".com");
//    flast@example.com (e.g., jdoe@example.com)
        System.out.println(firstName.charAt(0)+""+lastName+"@"+companyName+".com");
//    last.first@example.com (e.g., doe.john@example.com)
        System.out.println(lastName+"."+firstName+"@"+companyName+".com");
//    lastfirst@example.com (e.g., doejohn@example.com)
        System.out.println(lastName+""+firstName+"@"+companyName+".com");
//    last_first@example.com (e.g., doe_john@example.com)
        System.out.println(lastName+"_"+firstName+"@"+companyName+".com");
//    l.first@example.com (e.g., d.john@example.com)
        System.out.println(lastName.charAt(0)+"."+firstName+"@"+companyName+".com");
//    lfirst@example.com (e.g., djohn@example.com)
        System.out.println(lastName.charAt(0)+""+firstName+"@"+companyName+".com");
//    f_last@company.com (e.g., j_doe@company.com)
        System.out.println(firstName.charAt(0)+"_"+lastName+"@"+companyName+".com");
//    l_first@company.com (e.g., d_john@company.com)
        System.out.println(lastName.charAt(0)+"_"+firstName+"@"+companyName+".com");
    }
}
