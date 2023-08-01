package stack.problems;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path){
        Stack<String> st = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")){
                if (!st.isEmpty()){
                    st.pop();
                }
            }else if (!component.isEmpty() && !component.equals(".")){
                st.push(component);
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        for(String component: st){
            simplifiedPath.append("/").append(component);
        }
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath sol = new SimplifyPath();
        String path = "/document/.app/../../src/";
        System.out.println(sol.simplifyPath(path));
    }
}
