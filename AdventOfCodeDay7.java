import java.util.*;

public class AdventOfCodeDay7 {
    static class Pair {
        String name;
        long val;

        public Pair(String name, long val) {
            this.name = name;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Pair> stack = new Stack<>();
        HashMap<String, Long> map = new HashMap<>();
        while (true) {
            try {
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                if (arr[0].equals("$")) {
                    if (arr[1].equals("cd")) {
                        if (arr[2].equals("..")) {
                            Pair p = stack.pop();
                            long v = map.get(p.name);
                            map.put(p.name, p.val + v);
                            if (!stack.isEmpty()) {
                                Pair sp = stack.pop();
                                Pair np = new Pair(sp.name, sp.val + p.val);
                                stack.push(np);
                            }
                        } else {
                            String path;
                            if (stack.isEmpty()) {
                                path = "/";
                            } else {
                                path = stack.peek().name + "-" + arr[2];
                            }

                            if (map.containsKey(path)) {
                                stack.push(new Pair(path, map.get(path)));
                            } else {
                                stack.push(new Pair(path, 0));
                            }
                        }
                    }
                } else {
                    if (arr[0].equals("dir")) {
                        String path = stack.peek().name + "-" + arr[1];
                        if (!map.containsKey(path)) map.put(path, 0l);
                    } else {
                        long val = Long.parseLong(arr[0]);
                        Pair p = stack.pop();
                        Pair np = new Pair(p.name, p.val + val);
                        stack.push(np);
                    }
                }

            } catch (Exception e) {
                long add = 0;
                while (!stack.isEmpty()) {
                    Pair p = stack.pop();
                    add = add + p.val;
                    map.put(p.name, map.getOrDefault(p.name, 0l) + add);

                }
                // long sum=0;
                // for(String s:map.keySet()){
                //     if(map.get(s)<=100000)sum+=map.get(s);
                // }
                long used = 70000000 - map.get("/");
                long need = 30000000 - used;
                long min = Integer.MAX_VALUE;
                for (String s : map.keySet()) {
                    if (map.get(s) >= need) {
                        min = Math.min(min, map.get(s));
                    }
                }
                // System.out.println(sum+" "+map.get("/")+" "+find);
                System.out.println(min);
                break;
            }
        }
    }
}

