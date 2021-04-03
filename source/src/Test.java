public class Test {


    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();


        String a="a b c d  e";
        test.reverseWords(a);

    }


    public String reverseWords(String s) {
        String[] strs=s.split(" ");
        String res="";
        for(int i=strs.length-1;i>=0;--i) {
            res+=strs[i].replace(" ","");
            if(i!=0){
                res+=" ";
            }

        }
        return res;
    }


}




