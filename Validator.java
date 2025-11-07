/**
 * Класс валидации
 */
public abstract class Validator {

    /**
     * Метод проверки всех параметров
     * @param title название фильма
     * @param director режиссер
     * @param rentalcost стоимость проката
     * @param year год выпуска
     * @return булево значение соответствия параметров допустимым значениям
     */
    public static boolean paramsValidate(String title, String director, int rentalcost, int year,  String firstSpecificField, String secondSpecificField) {
        return nameValidate(title) && personNameValidate(director) && rentalcostValidate(rentalcost) && yearValidate (year)
                && stringFieldValidate(firstSpecificField) && stringsecondFieldValidate(secondSpecificField);
    }

    /**
     * Метод проверки имени Режиссера
     * @param personName имя деятеля
     * @return значение соответствия имени
     */
    public static boolean personNameValidate(String personName) {
        String nameRegex = "[А-ЯЁ][а-яё]+(\\s[А-ЯЁ][а-яё]+)*";
        return personName.matches(nameRegex);
    }

    /**
     * Метод проверки года
     * @param year год выпуска
     * @return булево значение соответствия года
     */
    public static boolean yearValidate(int year) {
        return 1900 <= year && year <= 2025;
    }

    /**
     * Метод проверки стоимости проката
     * @param rentalcost стоимости проката
     * @return булево значение стоимости проката
     */
    public static boolean rentalcostValidate(int rentalcost) {
        return 0 <= rentalcost ;
    }

    /**
     * Метод проверки названия фильма
     * @param title название
     * @return булево значение соответствия названия шаблону
     */
    public static boolean nameValidate(String title) {
        String nameRegex = "[А-ЯЁ][а-яА-ЯёЁ]+(\\s[А-ЯЁ][а-яА-Яё]+)*";
        return title.matches(nameRegex);
    }

    public static boolean stringFieldValidate(String stringField) {
        String regex = "[А-Яа-яёЁ]*[а-яё]+";
        return stringField.matches(regex);
    }

    public static boolean stringsecondFieldValidate(String secondSpecificField) {
        String regex = "[А-Яа-яёЁ]*[а-яё]+";
        return secondSpecificField.matches(regex);
    }




    /**
     * Метод вывода сообщения о результатах валидации
     * @param title название
     * @param supervisorName имя худрука
     * @param rentalcost стоимость проката
     * @param year год выпуска
     * @return булево значение соответствия параметров допустимым значениям
     */
    public static String validateMessage(String title, String supervisorName, int rentalcost, int year,  String firstSpecificField, String secondSpecificField) {
        String message = "";
        if (!paramsValidate(title, supervisorName, rentalcost, year, firstSpecificField, secondSpecificField)) {
            if (!nameValidate(title))
                message += "Поле 1: Неверное название фильма!\n";
            if (!personNameValidate(supervisorName))
                message += "Поле 2: Неверное имя режиссера!\n";
            if (!rentalcostValidate(rentalcost))
                message += "Поле 3: Рейтинг не может быть меньше 0 стоимость проката!\n";
            if (!yearValidate(year))
                message += "Поле 4: год не может быть меньше 1900 и больше 2025!\n";
            if (!stringFieldValidate(firstSpecificField))
                message += "Поле 5: Введённое значение содержит недопустимые символы!\n";
            if (!stringsecondFieldValidate(firstSpecificField))
                message += "Поле 6: Недопустимое значение для имени!";
        } else {
            message = "Все значения верны!";
        }
        return message;
    }
}

