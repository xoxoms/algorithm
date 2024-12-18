import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HuntMonsterJava {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line1 = br.readLine();
//        String line2 = br.readLine();


        String line1 = "4";
//        String line2 = "4 3 2 1";
        String line2 = "1 2 3 4";


        int size = Integer.parseInt(line1);
        String[] split2 = line2.split(" ");
        HashMap<Long, Long> cache = new HashMap<>();
        HashMap<Long, Long> cache2 = new HashMap<>();

        ArrayList<Long> monster = new ArrayList<>();
        for (String s : split2) {
            long value = Long.parseLong(s);
            monster.add(value);
            cache.put(value, cache.getOrDefault(value, 0L) + 1);
        }

        long prev = 0L;
        for (Map.Entry<Long, Long> e : cache.entrySet().stream().sorted().toList()) {
            long value = (cache.get(e.getKey()) * e.getKey()) + prev;
            cache2.put(e.getKey(), value);
            prev = value;
        }
        cache2.put(0L, 0L);

        for (int i = 0; i < size; i++) {
            long minus1 = monster.get(i) - 1;
            long result = cache2.get(minus1) + 1;
            for (int j = 0; j < i; j++) {
                if (monster.get(j) > minus1) {
                    result++;
                }
            }
            System.out.println(result);
        }

//
//        int size = Integer.parseInt(line1);
//        String[] split2 = line2.split(" ");
//        HashMap<Long, Long> cache = new HashMap<>();
//
//        Integer[] monster = new Integer[size];
//        for (int i = 0; i < split2.length; i++) {
//            monster[i] = Integer.valueOf(split2[i]);
//        }
//
//        long current = 1L;
//        long count = 0L;
//        cache.put(0L, 0L);
//        cache.put(1L, 0L);
//        do {
//            for (Integer integer : monster) {
//                if (integer >= current) {
//                    count++;
//                }
//            }
//
//            cache.put(current, count);
//            if (current - 1 > -1 && cache.get(current - 1) == count) {
//                break;
//            }
//            current++;
//        } while (true);
//
//        for (int i = 0; i < size; i++) {
//            long minus1 = monster[i] - 1;
//            long result = cache.get(minus1) + 1;
//            for (int j = 0; j < i; j++) {
//                if (monster[j] > minus1) {
//                    result++;
//                }
//            }
//            System.out.println(result);
//        }
    }
}
