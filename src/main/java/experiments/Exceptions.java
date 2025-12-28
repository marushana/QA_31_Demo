package experiments;

public class Exceptions {
    public static void main(String[] args) {
        String[] strArray = {"str1", "str", "str2"};
        try {
            pause();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("method is working");
        }

        unchekedException(strArray);
    }

    private static void unchekedException(String[] strArray) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(strArray[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
        System.out.println("prog is working");
    }

    private static void pause() throws InterruptedException {
        checkException();
        System.out.println("pause 3 sec");
    }

    private static void checkException() throws InterruptedException {
        Thread.sleep(3000);
    }

    //lhlh
}
