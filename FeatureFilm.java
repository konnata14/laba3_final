/**
 * Класс Художественный фильм
 */
public class FeatureFilm extends Film {

    /** Жанр фильма */
    private String _genre;

    /** Основан на реальных событиях*/
    private String _basedonreal;

    /**
     * Конструктор по умолчанию
     */
    FeatureFilm() {
        super();
        this._genre = "Не задано";
        this._basedonreal = "Не задано";
    }

    /**
     * Конструктор с параметрами
     * @param title название фильма
     * @param director режиссер
     * @param rentalcost стоимость проката
     * @param year год выпуска
     * @param basedonreal основан на реальных событиях
     * @param genre основной жанр
     */
    FeatureFilm(String title, String director, int rentalcost ,int year, String genre, String basedonreal) {
        super(title, director, rentalcost, year);
        this._genre = genre;
        this._basedonreal = basedonreal;
    }

    @Override
    public String getNewFirstSpecificField(String newBasedonreal) {
        this._basedonreal = newBasedonreal;
        return print();
    }

    @Override
    public String getNewSecondSpecificField(String newGenre) {
        this._genre = newGenre;
        return print();
    }

    @Override
    public String print() {
        String message = super.print();
        message += "Жанр: " + this._genre + "\n";
        message += "Основан на реальных событиях: " + this._basedonreal + "\n";
        return message;
    }

    @Override
    public String fieldInformation() {
        String message = super.fieldInformation();
        message += "5. Жанр: " + this._genre + "\n";
        message += "6. Основан на реальных событиях: " + this._basedonreal + "\n";
        return message;
    }
}
