import java.util.Scanner;

/**
 * Класс взаимодействия с пользователем
 */
public class UI {

    /** Поле класса - объект класса Scanner */
    private static Scanner _sc;

    /**
     * Конструктор по умолчанию
     */
    UI() {
        _sc = new Scanner(System.in);
    }

    /**
     * Выводит информационное сообщение в начале работы программы
     */
    private void getInformationMessage() {
        System.out.println("Лабораторная работа №3");
        System.out.println("Бригада 14:  Коноплева Н., Шадчина С.");
        System.out.println("Вариант 14: Фильмы\n");
    }

    /**
     * Выводит список возможностей приложения
     */
    private void menu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить фильм");
        System.out.println("2. Вывести все фильмы");
        System.out.println("3. Поиск театра по режиссера");
        System.out.println("4. Определить фильм с наибольшей стоимостью проката");
        System.out.println("5. Сортировать фильмы по названию ");
        System.out.println("6. Выбрать фильм");
        System.out.println("Для выхода введите пустую строку...");
        System.out.print("Ваше действие: ");
    }

    /**
     * Метод взаимодействия с пользователем
     */
    public void run() {
        getInformationMessage();

        menu();
        String choice = _sc.nextLine();
        while (!choice.isEmpty()) {
            try {
                switch (choice) {
                    case "1":
                        addNewFilm();
                        break;
                    case "2":
                        System.out.print(Film.showAll());
                        break;
                    case "3":
                        findByTitle();
                        break;
                    case "4":
                        determineTheHighestRentalCost();
                        break;
                    case "5":
                        System.out.print(Film.sortByName());
                        break;
                    case "6" :
                        interactionWithFilm();
                        break;
                    default:
                        System.out.println("Действие не распознано!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода данных: " + e.getMessage());
            }
            menu();
            choice = _sc.nextLine();
        }
        System.out.println("Вы вышли из программы!");

    }

    /**
     * Инициирует добавление нового фильма
     */
    private void addNewFilm() {
        System.out.println("Выберите тип фильма: ");
        System.out.println("1 - художественный: ");
        System.out.println("2 - документальный: ");
        System.out.print("Ваш выбор: ");
        String input = _sc.nextLine();

        if (input.equals("1")) {
            addFeatureFilmMenu();
        } else if (input.equals("2")){
            addDocumentaryFilmMenu();
        } else {
            System.out.println("Тип фильма указан неверно!\n");
        }
    }

    /**
     * Метод, инициирующий поиск фильма по названию
     */
    private void findByTitle() {
        if (!Film._array.isEmpty()) {
            System.out.print("Введите название: ");
            System.out.println(Film.findByTitle(_sc.nextLine()));
        } else {
            System.out.println("Действие невозможно: список пуст!\n");
        }
    }

    /**
     * Метод взаимодействия с фильмами
     */
    private void interactionWithFilm() {
        if (!Film._array.isEmpty()) {
            System.out.println(Film.showAll());
            System.out.print("Выберите фильм: ");
            int index = Integer.parseInt(_sc.nextLine());
            if (1 <= index && index <= Film.getSize()) {
                System.out.println("Выберите действие: ");
                System.out.println("1. Посмотреть информацию о фильме");
                System.out.println("2. Редактировать данные о фильме");
                System.out.println("3. Удалить фильм");
                System.out.println("Для возвращения введите пустую строку...");
                System.out.print("Ваше действие: ");
                String choice = _sc.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println(Film.findByIndex(index - 1));
                        break;
                    case "2":
                        fieldReplacement(index - 1);
                        break;
                    case "3":
                        Film.removeByIndex(index - 1);
                        System.out.println("Фильм удалён!");
                        break;
                    default:
                        System.out.println("Указан неверный номер фильма!\n");
                        break;
                }
            } else {
                System.out.println("Действие невозможно: список пуст!\n");
            }
        }
    }

    /**
     * Метод, инициирующий поиск фильма с самой высокой стоимость проката
     */
    private void determineTheHighestRentalCost() {
        if (!Film._array.isEmpty()) {
            System.out.println(Film.getFilmsAboveAverageRentalCost());
        } else {
            System.out.println("Действие невозможно: список пуст!\n");
        }
    }

    /**
     * Метод, инициирующий добавление нового художественного фильма
     */
    private void addFeatureFilmMenu() {
        System.out.print("Введите название фильма: ");
        String title = _sc.nextLine();
        System.out.print("Введите режиссера: ");
        String director = _sc.nextLine();
        System.out.print("Введите стоимость проката: ");
        int rentalcost = Integer.parseInt(_sc.nextLine());
        System.out.print("Введите год: ");
        int year= Integer.parseInt(_sc.nextLine());
        System.out.print("Введите жанр: ");
        String genre = _sc.nextLine();
        System.out.print("Введите основан ли он на реальных событиях: ");
        String basedonreal = _sc.nextLine();
        if (Validator.paramsValidate(title, director, rentalcost, year, genre, basedonreal)) {
            Film.addFeatureFilm(title, director, rentalcost, year, genre, basedonreal);
            System.out.println("Художественный фильмуспешно добавлен!\n");
        } else {
            System.out.println("Художественный фильм не может быть добавлен! Ошибки:\n" +
                    Validator.validateMessage(title, director, rentalcost, year, genre, basedonreal));
        }
    }

    /**
     * Метод, инициирующий добавление нового документального фильма
     */
    private void addDocumentaryFilmMenu() {
        System.out.print("Введите название фильма: ");
        String title = _sc.nextLine();
        System.out.print("Введите режиссера: ");
        String director = _sc.nextLine();
        System.out.print("Введите стоимость проката: ");
        int rentalcost = Integer.parseInt(_sc.nextLine());
        System.out.print("Введите год: ");
        int year= Integer.parseInt(_sc.nextLine());
        System.out.print("Введите предмет исследования: ");
        String subject = _sc.nextLine();
        System.out.print("Введите источник информации: ");
        String source = _sc.nextLine();
        if (Validator.paramsValidate(title, director, rentalcost, year, subject , source)) {
            Film.addDocumentaryFilm(title, director, rentalcost, year, subject , source);
            System.out.println("Документальный фильм успешно добавлен!\n");
        } else {
            System.out.println("Документальный фильм не может быть добавлен! Ошибки:\n" +
                    Validator.validateMessage(title, director, rentalcost, year, subject , source));
        }
    }

    /**
     * Метод взаимодействия с заменой полей
     * @param index индекс элемента списка
     */
    private void fieldReplacement(int index) {
        System.out.println("Выберите поле для изменения: ");
        System.out.print(Film._array.get(index).fieldInformation());
        System.out.print("Ваш выбор: ");
        String choice = _sc.nextLine();
        switch(choice) {
            case "1":
                System.out.print("Введите новое название: ");
                String newtitle = _sc.nextLine();
                System.out.println(Film._array.get(index).getNewtitle(newtitle));
                break;
            case "2":
                System.out.print("Введите новое имя: ");
                String newdirector = _sc.nextLine();
                System.out.println(Film._array.get(index).getNewdirector(newdirector));
                break;
            case "3":
                System.out.print("Введите новую стоимость проката: ");
                int newrentalcost = Integer.parseInt(_sc.nextLine());
                System.out.println(Film._array.get(index).getNewrentalcost(newrentalcost));
                break;
            case "4":
                System.out.print("Введите новый год выхода фильма: ");
                int newyear = Integer.parseInt(_sc.nextLine());
                System.out.println(Film._array.get(index).getNewyear(newyear));
                break;
            case "5":
                System.out.print("Введите новый значение: ");
                String newMeaning1 = _sc.nextLine();
                System.out.println(Film._array.get(index).getNewFirstSpecificField(newMeaning1));
                break;
            case "6":
                System.out.print("Введите новый значение: ");
                String newMeaning2 = _sc.nextLine();
                System.out.println(Film._array.get(index).getNewSecondSpecificField(newMeaning2));
                break;
        }
    }
}


