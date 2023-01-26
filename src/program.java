import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class program {
    public static void main(String[] args) {
        String json = "{{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"} " +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"} " +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";

        String filePath = "test.txt";

//        json = json.substring(4, json.length()-4);
//        String[] ar = json.split("},");
//        System.out.println(Arrays.toString(ar));


        String string = json.replace("{", "");
        String string_1 = string.replace("}", "");
        String s = string_1.replace(":", ",");
        String[] arr = s.split(" ");
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        String r = arr[0];
        String r1 = arr[1];
        String r2 = arr[2];

        System.out.println(r);
        System.out.println(r1);
        System.out.println(r2);


        String[] array = r.split(",");
        String[] array1 = r1.split(",");
        String[] array2 = r2.split(",");


        String res = "Студент" + " " + array[1] + " " + "получил" + " " + array[3] + " " + "по предмету" + " " + array[5];
        System.out.println(res);
        String res1 = "Студент" + " " + array1[1] + " " + "получил" + " " + array1[3] + " " + "по предмету" + " " + array1[5];
        System.out.println(res1);
        String res2 = "Студент" + " " + array2[1] + " " + "получил" + " " + array2[3] + " " + "по предмету" + " " + array2[5];
        System.out.println(res2);
        log(res, filePath);
        log(res1, filePath);
        log(res2, filePath);
    }

    static void log(String s, String filePath) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Все хорошо!");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(s.toString());
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }
}










