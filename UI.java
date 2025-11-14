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
        System.out.println("3. Поиск фильма по названию");
        System.out.println("4. Определить фильм с наибольшей стоимостью проката");
        System.out.println("5. Сортировать фильмы по названию ");
        System.out.println("6. Выбрать фильм");
        System.out.println("7. Определить фильм с самым ранним годом выпуска");
        System.out.println("Для выхода введите пустую строку...");
        System.out.print("Ваше действие: ");
    }

    /**
     * Метод взаимодействия с пользователем
     */
    public void run() {
        getInformationMessage();

        menu();
        String choice = "";
        try {
            choice = _sc.nextLine();
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }
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
                    case "7" :
                        determineyear();
                        break;
                    default:
                        System.out.println("Действие не распознано!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода данных: " + e.getMessage());
            }
            menu();
            try {
                choice = _sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ошибка ввода данных: " + e.getMessage());
               
            }
        }
        System.out.println("Вы вышли из программы!");

    }

    private void addNewFilm() {
        try {
            System.out.println("Выберите тип фильма:");
            System.out.println("1 - художественный");
            System.out.println("2 - документальный");
            System.out.print("Ваш выбор: ");
            String input = _sc.nextLine();

            switch (input) {
                case "1":
                    addFeatureFilmMenu();
                    break;
                case "2":
                    addDocumentaryFilmMenu();
                    break;
                default:
                    System.out.println("Тип фильма указан неверно!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Поиск фильма по названию
     */
    private void findByTitle() {
        try {
            if (!Film._array.isEmpty()) {
                System.out.print("Введите название: ");
                String title = _sc.nextLine();
                System.out.println(Film.findByTitle(title));
            } else {
                System.out.println("Список фильмов пуст!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Взаимодействие с выбранным фильмом
     */
    private void interactionWithFilm() {
        try {
            if (Film._array.isEmpty()) {
                System.out.println("Список фильмов пуст!\n");
                return;
            }

            System.out.println(Film.showAll());
            System.out.print("Выберите фильм: ");
            int index = Integer.parseInt(_sc.nextLine()) - 1;

            if (index < 0 || index >= Film.getSize()) {
                System.out.println("Неверный номер фильма!\n");
                return;
            }

            System.out.println("1. Посмотреть информацию о фильме");
            System.out.println("2. Редактировать данные о фильме");
            System.out.println("3. Удалить фильм");
            System.out.println("Для возвращения введите пустую строку...");
            System.out.print("Ваше действие: ");
            String action = _sc.nextLine();

            switch (action) {
                case "1":
                    System.out.println(Film.findByIndex(index));
                    break;
                case "2":
                    fieldReplacement(index);
                    break;
                case "3":
                    Film.removeByIndex(index);
                    System.out.println("Фильм удалён!");
                    break;
                default:
                    System.out.println("Неверный выбор!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Определение фильма с наибольшей стоимостью проката
     */
    private void determineTheHighestRentalCost() {
        try {
            if (!Film._array.isEmpty()) {
                System.out.println(Film.getFilmsAboveAverageRentalCost());
            } else {
                System.out.println("Список фильмов пуст!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Определение фильма с самым ранним годом выпуска
     */
    private void determineyear() {
        try {
            if (!Film._array.isEmpty()) {
                System.out.println(Film.getFilmsfirstyear());
            } else {
                System.out.println("Список фильмов пуст!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Добавление художественного фильма
     */
    private void addFeatureFilmMenu() {
        try {
            System.out.print("Введите название фильма: ");
            String title = _sc.nextLine();
            System.out.print("Введите режиссера: ");
            String director = _sc.nextLine();
            System.out.print("Введите стоимость проката: ");
            int rentalcost = Integer.parseInt(_sc.nextLine());
            System.out.print("Введите год: ");
            int year = Integer.parseInt(_sc.nextLine());
            System.out.print("Введите жанр: ");
            String genre = _sc.nextLine();
            System.out.print("Основан ли на реальных событиях: ");
            String basedonreal = _sc.nextLine();

            if (Validator.paramsValidate(title, director, rentalcost, year, genre, basedonreal)) {
                Film.addFeatureFilm(title, director, rentalcost, year, genre, basedonreal);
                System.out.println("Художественный фильм успешно добавлен!\n");
            } else {
                System.out.println("Ошибка при добавлении фильма:\n" +
                        Validator.validateMessage(title, director, rentalcost, year, genre, basedonreal));
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Добавление документального фильма
     */
    private void addDocumentaryFilmMenu() {
        try {
            System.out.print("Введите название фильма: ");
            String title = _sc.nextLine();
            System.out.print("Введите режиссера: ");
            String director = _sc.nextLine();
            System.out.print("Введите стоимость проката: ");
            int rentalcost = Integer.parseInt(_sc.nextLine());
            System.out.print("Введите год: ");
            int year = Integer.parseInt(_sc.nextLine());
            System.out.print("Введите предмет исследования: ");
            String subject = _sc.nextLine();
            System.out.print("Введите источник информации: ");
            String source = _sc.nextLine();

            if (Validator.paramsValidate(title, director, rentalcost, year, subject, source)) {
                Film.addDocumentaryFilm(title, director, rentalcost, year, subject, source);
                System.out.println("Документальный фильм успешно добавлен!\n");
            } else {
                System.out.println("Ошибка при добавлении фильма:\n" +
                        Validator.validateMessage(title, director, rentalcost, year, subject, source));
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Замена полей фильма
     */
    private void fieldReplacement(int index) {
        try {
            System.out.println("Выберите поле для изменения: ");
            System.out.print(Film._array.get(index).fieldInformation());
            System.out.print("Ваш выбор: ");
            String choice = _sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите новое название: ");
                    String newTitle = _sc.nextLine();
                    System.out.println(Film._array.get(index).getNewtitle(newTitle));
                    break;
                case "2":
                    System.out.print("Введите новое имя: ");
                    String newDirector = _sc.nextLine();
                    System.out.println(Film._array.get(index).getNewdirector(newDirector));
                    break;
                case "3":
                    System.out.print("Введите новую стоимость проката: ");
                    int newRentalcost = Integer.parseInt(_sc.nextLine());
                    System.out.println(Film._array.get(index).getNewrentalcost(newRentalcost));
                    break;
                case "4":
                    System.out.print("Введите новый год: ");
                    int newYear = Integer.parseInt(_sc.nextLine());
                    System.out.println(Film._array.get(index).getNewyear(newYear));
                    break;
                case "5":
                    System.out.print("Введите новое значение: ");
                    String newMeaning1 = _sc.nextLine();
                    System.out.println(Film._array.get(index).getNewFirstSpecificField(newMeaning1));
                    break;
                case "6":
                    System.out.print("Введите новое значение: ");
                    String newMeaning2 = _sc.nextLine();
                    System.out.println(Film._array.get(index).getNewSecondSpecificField(newMeaning2));
                    break;
                default:
                    System.out.println("Неверный выбор!\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }
}
