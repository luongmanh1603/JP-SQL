package demo3;

public class Main {
    public static void main(String[] args) {
//subthread
//        SubThread st1 = new SubThread();
//        st1.start();
//        //subrunable
//        subrun sr1 = new subrun();
//        Thread st2 = new Thread(sr1);
//        st2.start();
        Runnable r1 = ()
                ->{
            for (int i =9;i<20;i++){
                System.out.println(" lamda i="+i);
                try {
                    Thread.sleep(1000);//1000 millionseconds
                } catch (Exception e){}
            }
        };
        new Thread(()->{
            for (int i =9;i<20;i++){
                System.out.println(" runable i="+i);
                try {
                    Thread.sleep(1000);//1000 millionseconds
                } catch (Exception e){}
            }
        }).start();
   for (int i =9;i<20;i++){
       System.out.println("i="+i);
       try {
           Thread.sleep(1000);//1000 millionseconds
       } catch (Exception e){}
   }

    }
}
