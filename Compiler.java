import java.util.LinkedList;
import java.util.regex.*;

public class Compiler { 
    
    public static LinkedList<String> ids=new LinkedList<String>();
    public static LinkedList<String> moteCle=new LinkedList<String>();
    public static LinkedList<String> op=new LinkedList<String>();
    public static LinkedList<String> sep=new LinkedList<String>();
    public static LinkedList<String> cons=new LinkedList<String>();
    public static LinkedList<String> ids_count=new LinkedList<String>();
    public static LinkedList<String> sep_count=new LinkedList<String>();
    public static LinkedList<String> op_count=new LinkedList<String>();
    public static LinkedList<String> moteCle_count=new LinkedList<String>();
    public static LinkedList<String> cons_count=new LinkedList<String>();        
    public static String [] moteClé={"write","read","int","String","begin","if","else"};
    
static void regex (String reg , String txt) {
    int  j=0;
        Pattern p= Pattern.compile(reg);
        Matcher RegMatcher = p.matcher(txt);
        boolean b= RegMatcher.matches();
        while (RegMatcher.find()) {
            if (RegMatcher.group().length() != 0){
             if ("[a-zA-Z]+[a-zA-Z0-9_]*".equals(reg)){ 
                String re = RegMatcher.group().trim();
                if (!re.equals(moteClé[j])){
                    ids.add(RegMatcher.group().trim());
                }else j++ ;
              }else if ("/|(\\*)|-|(\\+)".equals(reg)){
                 op.add(RegMatcher.group().trim());
              }else if ("[(;([)]]|(:=)".equals(reg)){
                 sep.add(RegMatcher.group().trim());   
              }else if ("\\d+(\\.\\d+)?".equals(reg)){
                  cons.add(RegMatcher.group().trim());
              }else {
                  moteCle.add(RegMatcher.group().trim());
              }
            }
        }
}
    public static void main(String[] args) {
        String txt = " aa; a_a:=22*2/3.1-7; write(a_a); aa; read(a) " ;
        System.out.println("@ Le code final :"+txt);  
        regex("[a-zA-Z]+[a-zA-Z0-9_]*",txt);
        regex("/|(\\*)|-|(\\+)",txt);
        for (int i=0 ; i<7 ; i++) {
        regex(moteClé[i],txt);
        }      
        regex("[(;([)]]|(:=)",txt);
        regex("\\d+(\\.\\d+)?",txt);
        
        int count=0 ;
        for (int i = 0 ; i < ids.size() ; i++) {
            for (int j = i+1 ; j < ids.size() ; j++) {
                if (ids.get(i).equals(ids.get(j))) count++;
            }
            if (count !=0 ) {
                for (int f=0 ; f < count ; f++){
                 ids.removeLastOccurrence(ids.get(i));   
                }
            }
            count++ ;
            String count2 = Integer.toString(count);
            ids_count.add(count2);
            count = 0 ;
        }
        System.out.println();
        System.out.println("@ Les ideficateur variable : ");
        System.out.println(ids);
        System.out.println(ids_count);
        
        for (int i = 0 ; i < moteCle.size() ; i++) {
            for (int j = i+1 ; j < moteCle.size() ; j++) {
                if (moteCle.get(i).equals(moteCle.get(j))) count++;
            }
            if (count !=0 ) {
                for (int f=0 ; f < count ; f++){
                 moteCle.removeLastOccurrence(moteCle.get(i));   
                }
            }
            count++ ;
            String count2 = Integer.toString(count);
            moteCle_count.add(count2);
            count = 0 ;
        }
        System.out.println();
        System.out.println("@ les mote clé :");
        System.out.println(moteCle);
        System.out.println(moteCle_count);
        
        for (int i = 0 ; i < sep.size() ; i++) {
            for (int j = i+1 ; j < sep.size() ; j++) {
                if (sep.get(i).equals(sep.get(j))) count++;
            }
            if (count !=0 ) {
                for (int f=0 ; f < count ; f++){
                 sep.removeLastOccurrence(sep.get(i));   
                }
            }
            count++ ;
            String count2 = Integer.toString(count);
            sep_count.add(count2);
            count = 0 ;
        }
        System.out.println();
        System.out.println("@ Les séparateur :");
        System.out.println(sep);
        System.out.println(sep_count);
        
        for (int i = 0 ; i < op.size() ; i++) {
            for (int j = i+1 ; j < op.size() ; j++) {
                if (op.get(i).equals(op.get(j))) count++;
            }
            if (count !=0 ) {
                for (int f=0 ; f < count ; f++){
                 op.removeLastOccurrence(op.get(i));   
                }
            }
            count++ ;
            String count2 = Integer.toString(count);
            op_count.add(count2);
            count = 0 ;
        }
        System.out.println();
        System.out.println("@ Les opérateur :");
        System.out.println(op);
        System.out.println(op_count);
        
        for (int i = 0 ; i < cons.size() ; i++) {
            for (int j = i+1 ; j < cons.size() ; j++) {
                if (cons.get(i).equals(cons.get(j))) count++;
            }
            if (count !=0 ) {
                for (int f=0 ; f < count ; f++){
                 cons.removeLastOccurrence(cons.get(i));   
                }
            }
            count++ ;
            String count2 = Integer.toString(count);
            cons_count.add(count2);
            count = 0 ;
        }
        System.out.println();
        System.out.println("@ Les const : ");
        System.out.println(cons);
        System.out.println(cons_count);
    }
}