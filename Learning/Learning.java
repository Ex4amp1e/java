import java.util.*;

public final class Learning {

    private static HashMap<Integer, Integer> commentMap = new HashMap<>(); // Key - id, Value - parent id
    private static HashMap<Integer, ArrayList> commentMapReversed = new HashMap<>(); // Key - id, Value - список id комментариев-потомков
    private static int summ; // Сумма всех дочерних комментариев


    private static void add(int c_id, int p_id) { // c_id - comment id, p_id - parent id
        ArrayList<Integer> commentList = new ArrayList<>();
        commentMap.put(c_id, p_id);
        if (commentMapReversed.containsKey(p_id)) {
            commentList = commentMapReversed.get(p_id);
        }
        commentList.add(c_id);
        commentMapReversed.put(p_id, commentList);
    }

    private static void remove(int c_id) {
        if (commentMapReversed.containsKey(c_id)) {
            ArrayList<Integer> commentList = commentMapReversed.get(c_id);
            for (int i = 0; i < commentList.size(); i++) {
                int id = commentList.get(i);
                remove(id);
            }
        }
        int p_id = commentMap.get(c_id);
        ArrayList<Integer> commentList = commentMapReversed.get(p_id);
        Iterator<Integer> it = commentList.iterator();
        while (it.hasNext()) {
            Integer nextInt = it.next();
            if (nextInt == c_id) {
                it.remove();
            }
        }
        if (commentMapReversed.size() > 0) {
            commentMapReversed.put(c_id, commentList);
        } else {
            commentMapReversed.remove(c_id);
        }
        commentMap.remove(c_id);
    }

    private static void find(int c_id) {
        if (commentMapReversed.containsKey(c_id)) {
            ArrayList<Integer> commentList = commentMapReversed.get(c_id);
            for (int i = 0; i < commentList.size(); i++) {
                summ++;
                int p_id = commentList.get(i);
                find(p_id);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int c_id, p_id;
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            c_id = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "ADD":
                    p_id = Integer.parseInt(s[2]);
                    if ((commentMap.containsKey(p_id) || p_id == -1) && !commentMap.containsKey(c_id)) {
                        add(c_id, p_id);
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "REMOVE":
                    if (commentMap.containsKey(c_id)) {
                        remove(c_id);
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "FIND":
                    if (commentMap.containsKey(c_id)) {
                        summ = 1;
                        find(c_id);
                        System.out.println(summ);
                    } else {
                        System.out.println("0");
                    }
                    break;
            }

        }

    }
}