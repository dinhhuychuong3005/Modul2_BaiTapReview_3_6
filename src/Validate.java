import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private final String BIRTHDAY_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private final String ID_REGEX = "^[C][0-9]{4}[GHIK]{1}[0-9]{1}$";
    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
private final String NAME_REGEX = "^[\\p{L} .'-]+$";
    public boolean validateBirthDay(String regex) {
        Pattern pattern = Pattern.compile(BIRTHDAY_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    public int getValidDate() {
        Scanner SCANNER = new Scanner(System.in);
        int day, month, year;
        Calendar cal = Calendar.getInstance();
        String inputString;
        do {
            System.out.print("Nhập vào ngày tháng năm 'dd/MM/yyyy': ");
            inputString = SCANNER.nextLine();
            String[] strings = inputString.split("/");
            day = Integer.parseInt(strings[0]);
            month = Integer.parseInt(strings[1]);
            year = Integer.parseInt(strings[2]);
            if ((!validateBirthDay(inputString)) || (year >= LocalDate.now().getYear())) {
                System.out.println("mời nhập lại năm sinh");
            }
        } while ((!validateBirthDay(inputString)) || (year >= LocalDate.now().getYear()));
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }

    public boolean validateId(String regex) {
        Pattern pattern = Pattern.compile(ID_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean validateEmail(String regex){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean validateName(String regex){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
