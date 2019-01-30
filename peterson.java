public class peterson {
    public  static int counter = 0;
    public static void inc(){
        counter++;

    }
    public static void dec(){
        counter--;
    }


    public static boolean[] flag = {false, false};
    public static int turn;
    public static void main(String args[]) {



        Thread t1 = new Thread(new Runnable() {
            public void run() {
                {
                    flag[1] = true;
                    turn = 0;
                    while (flag[0] && turn == 0){
                        System.out.println("Thread 1 is Waiting...");
                    };

                    for (int i = 0; i <= 20000000; i++){
                        inc();
                    }
                    flag[1] = false;
                };

            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                {
                    flag[0] = true;
                    turn = 1;
                    while (flag[1] && turn == 1){
                        System.out.println("Thread 2 is Waiting...");
                    };

                    for (int i = 0; i <= 20000000; i++){
                        dec();
                    }
                    flag[1] = false;
                }


            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Value = "+counter);
        } catch (Exception e){

        }
    }


}
