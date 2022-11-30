package codingInterview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class StringSimilarity {

    public static void main(String[] args) throws IOException {

        List<Boolean> l = new ArrayList<>();
        StringSimilarity s = new StringSimilarity();


        ArrayList<String> lst = new ArrayList<String>();
        lst.add("adsd,ad");
        lst.add("adsdad,dadas");
        s.solution(lst);

        //l.add(s.solution(new ArrayList<String>("as,sd", "asds,sdf")) == 0);
        //l.add(Arrays.equals(s.solution(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public String solution(List<String> list) {

        String st = "";

        for (int i = 0; i < list.size() - 1; i++) {
            st += (list.get(i) + ";");
        }

        if (list.size() > 1) {
            st += list.get(list.size() - 1);
        }

        out.println(st);
        return st;
    }
}