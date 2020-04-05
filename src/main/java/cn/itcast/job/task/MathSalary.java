package cn.itcast.job.task;

public class MathSalary {


    public static Integer[] getSalary(String strSalary) {
        Integer[] salary=new Integer[2];
        String str1="";
        String str2="";
        boolean flag=false;
        for(int i=0;i<strSalary.length();i++) {
            if(flag==false) {
                if(strSalary.charAt(i)>=48 && strSalary.charAt(i)<=57) {
                    str1+=strSalary.charAt(i);
                }
                else if(strSalary.charAt(i)==45) {
                    flag=true;
                    continue;
                }
            }
            else if(flag==true) {
                if(strSalary.charAt(i)>=48 && strSalary.charAt(i)<=57) {
                    str2+=strSalary.charAt(i);
                }
            }
        }
        salary[0]=Integer.parseInt(str1);
        salary[1]=Integer.parseInt(str2);
        return salary;
    }
}
