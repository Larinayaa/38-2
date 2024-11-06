import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иван");
        Person person2 = new Person("Анна");
        Account account1 = new Account("DE1234532", new BigDecimal("543"), person1); // по паре счетов каждому
        Account account2 = new Account("DE8754488", new BigDecimal("112"), person1);
        Account account3 = new Account("DE6544778", new BigDecimal("4532"), person2);
        Account account4 = new Account("DE8654788", new BigDecimal("9424"), person2);
        Map<Person, List<Account>> mapPoaccount = new HashMap<>(); // ключом будет персона а значением его аккаунт
        mapPoaccount.put(person1, List.of(account1, account2)); // Добавляем счета первой персоне
        mapPoaccount.put(person2, List.of(account3, account4,account1)); //добавили второму ошибочный первый аккаунт кроме ее
        boolean oshibki = proverkaNaOshibki(mapPoaccount); //проверка ошибок
        System.out.println("--------ЕСТЬ ЛИ ОШИБКИ?---------");
        System.out.println(oshibki);
    }
    public static boolean proverkaNaOshibki(Map<Person, List<Account>> accountsMap) {//метод проверка на наличие ошибок в мап
        for (Map.Entry<Person, List<Account>> entry : accountsMap.entrySet()) {
            Person person = entry.getKey();
            List<Account> accounts = entry.getValue();
            for (Account account : accounts) {
                if (!account.getOwner().equals(person)) {  // если персона не владелец то ошибка найдена
                    return true; // Ошибка найдена, возвращаем true
                }
            }
        }
        return false; // если нет ошибок то возврат фальш - проверка дала негативный результат, ошибок нет
    }
}