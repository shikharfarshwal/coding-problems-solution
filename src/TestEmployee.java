import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Function;

/**
 *  Created by Shikhar on 03-01-2018.
  */



public class TestEmployee {
public final int value=11;
    static int portNo=6565;

    public static void main(String[] args) {
        int value=5;
        Employee emp1=new Employee(1,"shikh","PES");
        Employee emp2=new Employee(2,"sAHIL","PES");
        Employee emp3=new Employee(3,"aaaaa","AP1");

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(emp1);
        //employeeList.add(emp2);
        employeeList.add(0,emp3);
       // employeeList.forEach(e->System.out.println("employee before sorting"+e.getId()+" "+e.getDepartment()+" "+e.getName()));

        Set<Integer> linkIntegerSet=new LinkedHashSet<>();
        linkIntegerSet.add(1);
        linkIntegerSet.add(2);
        linkIntegerSet.add(3);
        linkIntegerSet.add(1);

        Iterator<Integer> iterator = linkIntegerSet.iterator();
        System.out.println("Printing via external iterator");
        while(iterator.hasNext()){
            System.out.println("linked hashset elements are"+iterator.next());
        }
        System.out.println("Printing via internal iterator");
        linkIntegerSet.forEach(System.out::println);
        //-------------------------------------------------------------------------------------------//
        Map<Object,String> vhg=new HashMap<>();
        vhg.put("gh","ghfhg");
        //------------------------------------------------------------------------------------------//
        Set<Integer> treeSet=new TreeSet<>(Comparator.comparing(Integer::intValue).reversed().reversed());
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(1);
        System.out.println("Printing treeset elements");
        treeSet.forEach(System.out::println);
        //------------------------------------------------------------------------------------------//
       Set<Employee> employees=new TreeSet<>(Comparator.comparing(Employee::getName));
       employees.add(emp1);
       employees.add(emp2);
       employees.add(emp3);
       System.out.println("Printing custom employee treeset element --------------------------------");
       employees.stream().forEach(System.out::println);

        // Collections.sort(employeeList,new EmployeeComparator());

        //employeeList.sort((Employee e1,Employee e2)->e1.getName().compareTo(e2.getName()));
        //employeeList.sort(Comparator.comparing(Employee::getName));
        //employeeList.forEach(e->System.out.println("employee after sorting"+e.getId()+" "+e.getDepartment()+" "+e.getName()));
        //iterateHashMap();

        //------------------------------------------------------------------------------------------//
        List<String> map = map(Arrays.asList("hejeh", "zxczxc", "dfsaasf"),
                (String s) -> s.replace('h', 'd'));
        map.forEach(System.out::println);
        //int portNo=6565;
       // Runnable o=()->{System.out.println("Tricky"+portNo);};
        portNo=79987;


        Map<Employee,Integer> empMap=new HashMap<>();
        empMap.put(emp1,1);
        empMap.put(emp2,2);
        empMap.put(emp3,3);

        //empMap.put(null,"5");

        //empMap.put(null,"6");
        //System.out.println(empMap.get(null));
        System.out.println("HashMap elements are");
        System.out.println(empMap.get(emp3));
        Set<Map.Entry<Employee, Integer>> entries = empMap.entrySet();
        entries.forEach(System.out::println);

        Hashtable<Employee,Integer> hashtable=new Hashtable<>();
        hashtable.put(emp1,1);
        hashtable.put(emp2,2);
        System.out.println("HashTable elements are");
        hashtable.entrySet().forEach(System.out::println);

        System.out.println("Hashset elelmnets are");
        Set<Employee> hashSet=new HashSet<>();
        hashSet.add(emp1);
        hashSet.add(emp2);
        // hashSet.add(2);
        // hashSet.add(3);
        hashSet.forEach(System.out::println);

                String h= "hello";
                String g=new String("hello");
                if(h==g){
                    System.out.println("ref are equal");
                }
                else
                    System.out.println("ref are not equal");
               // hashSet.
    }
    //------------------------------------------------------------------------------------------//
    private static void iterateHashMap() {
        Map<Integer,String> toIterate=new HashMap<>();
        toIterate.put(1,"HELLO");
        toIterate.put(2,"HELLO1");
        toIterate.put(3,"HELLO4");

        Set<Integer> integers = toIterate.keySet();
        for (Integer integer:
             integers) {
            System.out.println("Key is"+integer+"value is"+toIterate.get(integer));
        }
        //toIterate.entrySet().forEach((k)->System.out.println("the key values are "+k));
        toIterate.keySet().iterator().forEachRemaining(System.out::println);
        //toIterate.keySet().forEach((k)-> System.out.println("usinh java 8 keyset"+k+toIterate.get(k)));

        HashMap<String,Employee> stringEmployeeHashMap=new HashMap<>();

    }


    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result=new ArrayList<>();
        for(T s:list){
            result.add(f.apply(s));
        }
        return result;
    }
}
