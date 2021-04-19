import java.util.*;

public class tuple {

    public static void main(String[] args) {

        String s = "{{20,111},{111}}";
        solution(s);
    }

    static public int[] solution(String s) {

        int[] answer = {};
        String tempanswer = "";

        s = s.substring(2);
        s = s.substring(0,s.length()-2);
        //System.out.println(s);

        s = s.replace("},{","-");
        String[] arr = s.split("-");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]);
//            System.out.println();
//        }

        HashSet<String> hs = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int j=0;j<arr.length;j++){
            String[] temp = arr[j].split(",");
            for(int k = 0;k<temp.length;k++){
                if(hs.contains(temp[k])){
                    continue;
                }else{
                    hs.add(temp[k]);
                    tempanswer = tempanswer+temp[k];
                    arrayList.add(Integer.parseInt(temp[k]));
                }
            }
           System.out.println(tempanswer);

        }
        answer = new int[arrayList.size()];
        for(int t = 0;t<arrayList.size();t++){
            answer[t] = arrayList.get(t);
            System.out.println(answer[t]);
        }
        return answer;
    }
}
