import java.util.ArrayList;

/**
 * Абстрактный класс Фильм
 */
public abstract class Film {

    /** Название */
    protected String _title;

    /** Имя режиссера */
    protected String _director;

    /** Стоимость проката */
    protected int _rentalcost;

    /** Год выпуска*/
    protected int _year;

    /** Список фильмов */
    protected static ArrayList<Film> _array = new ArrayList<>();

    // Заполнение списка тестовыми значениями
    static {
        _array.add(new FeatureFilm("Интерстеллар", "Колен", 350, 2014, "Фантастика", "нет"));
        _array.add(new FeatureFilm("Алиса", "Балабанов",  200, 1997, "Фантастика", "нет"));
        _array.add(new DocumentaryFilm("Планета Земля", "Скотт", 140, 2001, "Появление жизни на планере", "Статьи с 1970-1999"));
        _array.add(new DocumentaryFilm("Когти", "Иванов", 400, 2005, "Хищники Африки", "Материалы скрытых камер"));
    }

    /**
     * Конструктор по умолчанию
     */
    Film() {
        this._title = "Не задано";
        this._director = "Не задано";
        this._rentalcost = 0;
        this._year=0;
    }

    /**
     * Конструктор с параметрами
     *
     * @param director режиссера
     * @param title название фильма
     */
    Film(String title, String director, int rentalcost, int year) {
        this();
        this._title =  title;
        this._director = director;
        this._rentalcost = rentalcost;
        this._year = year;
    }

    /**
     * Метод возвращает стоимость проката
     * @return стоимость проката фильма
     */
    public int getRentalcot() {
        return this._rentalcost;
    }

    /**
     * Метод возвращает год выпуска
     * @return год выпуска фильма
     */
    public int getYear() {
        return this._year;
    }

    /**
     * Метод вывода информации о полях фильма
     * @return сообщение о полях
     */
    public String fieldInformation() {
        String message = "1. Название: " + this._title + "\n";
        message += "2. Режиссер: " + this._director + "\n";
        message += "3. Стоимость проката: " + this._rentalcost + "\n";
        message += "4. Год выпуска: " + this._year + "\n";
        return message;
    }

    /**
     * Метод возвращает полную информацию о фильме
     * @return строка с информацией о фильме
     */
    public String print() {
        String message = "";
        message += "Название: " + this._title + "\n";
        message += "Режиссер: " + this._director + "\n";
        message += "Стоимость проката: " + this._rentalcost + "\n";
        message += "Год выпуска: " + this._year + "\n";
        return message;
    }

    /**
     * Метод замены режиссера
     * @param newdirector фамилия нового режиссера
     */
    public String getNewdirector (String newdirector) {
        this._director = newdirector;
        return print();
    }

    /**
     * Метод замены названия фильма
     * @param newtitle новое название фильма
     * @return информация о фильме после замены названия
     */
    public String getNewtitle (String newtitle) {
        this._title = newtitle;
        return print();
    }

    /**
     * Метод замены стоимости проката фильма
     * @param newrentalcost новая стоимость проката
     * @return информация о фильме после изменения стоимости проката
     */
    public String getNewrentalcost(int newrentalcost) {
        this._rentalcost = newrentalcost;
        return print();
    }

    /**
     * Метод замены года выпуска фильма
     * @param newyear новый год выпуска
     * @return информация о фильме после изменения года выпуска
     */
    public String getNewyear(int newyear) {
        this._year = newyear;
        return print();
    }

    /**
     * Метод замены первого уникального поля у класса-наследника
     * @param newSpecificField1 новое значение
     * @return информация о фильме после замены поля
     */
    abstract public String getNewFirstSpecificField(String newSpecificField1);

    /**
     * Метод замены второго уникального поля у класса-наследника
     * @param newSpecificField2 новое значение
     * @return информация о фильме после замены поля
     */
    abstract public String getNewSecondSpecificField(String newSpecificField2);

    /**
     * Метод возвращает размер списка с фильмами
     * @return размер списка
     */
    public static int getSize() {
        return _array.size();
    }

    /**
     * Метод сортирует список фильмов по названию в алфавитном порядке.
     * @return информация о списке после сортировки
     */
    public static String sortByName() {
        if (!_array.isEmpty()) {
            // создаем копию списка, чтобы не изменять оригинальный _array
            ArrayList<Film> sortedArray = new ArrayList<>(_array);

            // сортировка по названию (от A до Я, без учета регистра)
            sortedArray.sort((f1, f2) -> f1._title.compareToIgnoreCase(f2._title));

            // формируем строку-результат
            String message = "Список отсортирован по названиям фильмов (в алфавитном порядке):\n";
            for (int i = 0; i < sortedArray.size(); i++) {
                message += (i + 1) + ". " + sortedArray.get(i).print() + "\n";
            }
            return message;
        } else {
            return "Действие невозможно: список пуст!";
        }
    }


    /**
     * Метод добавляет новый художественный фильм в список фильмов
     * @param director имя режиссера
     * @param title название фильма
     * @param basedonreal основан на реальных событиях
     * @param genre основной жанр
     * @param rentalcost стоимость проката
     * @param year год выпуска
     */
    public static void addFeatureFilm(String title, String director, int rentalcost, int year, String genre,String basedonreal ) {
        _array.add(new FeatureFilm(title, director, rentalcost, year, genre, basedonreal));
    }

    /**
     * Метод добавляет новый художественный фильм в список фильмов
     * @param director имя режиссера
     * @param title название фильма
     * @param subject предмет исследования
     * @param source источник информации
     * @param rentalcost стоимость проката
     * @param year год выпуска
     */
    public static void addDocumentaryFilm(String title, String director, int rentalcost, int year, String subject, String source) {
        _array.add(new DocumentaryFilm(title, director,rentalcost, year, subject, source));
    }

    /**
     * Метод удаляет фильм из списка
     * @param index индекс фильма
     */
    public static void removeByIndex(int index) {
        _array.remove(index);
    }

    /**
     * Метод возвращает все фильмы в списке
     * @return строка с информацией обо всех фильмах
     */
    public static String showAll() {
        String message = "";
        if (!_array.isEmpty()) {
            for (int i = 0; i < _array.size(); i++)
                message += (i+1) + ". " + _array.get(i).print() + "\n";
        } else {
            message = "Список пуст!\n";
        }
        return message;
    }

    /**
     * Метод поиска фильма по названию
     * @param title название фильма
     * @return строка с информацией о фильме
     */
    public static String findByTitle(String title) {
        for (Film film : _array) {
            if (film._title.equals(title)) {
                return film.print();
            }
        }
        return "Театр не найден!\n";

    }


    /**
     * Метод определяет фильмы, стоимость проката которых выше средней.
     * @return строка с информацией о таких фильмах
     */
    public static String getFilmsAboveAverageRentalCost() {
        if (_array == null || _array.isEmpty()) {
            return "Список фильмов пуст.";
        }
        double totalCost = 0;
        for (Film film : _array) {
            totalCost += film.getRentalcot();  // метод getRentalcot() возвращает стоимость проката
        }
        double averageCost = totalCost / _array.size();

        StringBuilder result = new StringBuilder("Фильмы со стоимостью проката выше средней ("
                + averageCost + "):\n");

        boolean found = false; // чтобы проверить, есть ли такие фильмы
        for (Film film : _array) {
            if (film.getRentalcot() > averageCost) {
                found = true;
                result.append("- ").append(film._title)
                        .append(" — ").append(film._rentalcost)
                        .append(" руб.\n");
            }
        }

        if (!found) {
            return "Нет фильмов со стоимостью проката выше средней.";
        }
        return result.toString();
    }



    /**
     * Метод поиска фильма по индексу
     * @param index индекс фильма
     * @return информация о фильме
     */
    public static String findByIndex(int index) {
        return _array.get(index).print();
    }
}
