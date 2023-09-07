public class Program {
    public static void main(String[] args) throws Exception{
        try {
            UserInfo();
            System.out.println("Файл создан!");
        }catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
    }

    public static void UserInfo() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), " +
                "номер телефона (число без разделителей и без кода оператора)" +
                " и пол(символ латиницей f или m), разделенные пробелом");
        String str;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            str = bf.readLine();
        }catch (IOException e){
            throw new Exception("Произошла ошибка при работе с консолью");
        }

        String[] data = str.split(" ");
        if (data.length != 6) {
            throw new Exception("Данные введены не верно! Количество данных не соответствует!");
        }

        String lastName = data[0];
        String firstName = data[1];
        String surName = data[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth;
        try {
            dateOfBirth = format.parse(data[3]);
        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phoneNumber;
        try {
            phoneNumber = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат телефонного номера!");
        }

        String gender = data[5];
        if (!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")) {
            throw new RuntimeException("Неверно введен пол");
        }

        try {
            FileWriter writer = new FileWriter(lastName.toLowerCase() + ".txt");
            writer.write(String.format("%s %s %s %s %s %s",
                    lastName, firstName, surName, format.format(dateOfBirth), phoneNumber, gender));
            writer.close();
        } catch (IOException e) {
            throw new FileSystemException("Возникла ошибка при работе с файлом!");
        }
    }
}
