/**
 * Класс Документальный фильм
 */
public class DocumentaryFilm extends Film{

    /** Предмет исследования фильма */
    private String _subject;

    /** Источник информации */
    private String _sourse;

    /**
     * Конструктор по умолчанию
     */
    DocumentaryFilm() {
        super();
        this._subject = "Не задано";
        this._sourse = "Не задано";
    }

    /**
     * Конструктор с параметрами
     * @param title название фильма
     * @param director режиссер
     * @param rentalcost стоимость проката
     * @param year год выпуска
     * @param subject предмет исследования фильма
     * @param source источник информации
     */
    DocumentaryFilm(String title, String director, int rentalcost, int year,  String subject, String source) {
        super(title, director, rentalcost, year);
        this._subject = subject;
        this._sourse  = source;
    }

    @Override
    public String getNewFirstSpecificField(String newSubject) {
        this._subject  = newSubject;
        return print();
    }

    @Override
    public String getNewSecondSpecificField(String newSourse) {
        this._sourse = newSourse;
        return print();
    }

    @Override
    public String print() {
        String message = super.print();
        message += "Предмет исследования: " + this._subject + "\n";
        message += "Источник информации: " + this._sourse + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "5. Предмет исследования: " + this._subject;
        message += "6. Источник информации: " + this._sourse;
        return message;
    }
}
