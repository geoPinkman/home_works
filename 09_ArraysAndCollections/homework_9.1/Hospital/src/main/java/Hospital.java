public class Hospital {
    public final static int MIN_TEMPERATURE = 32;
    public final static int MAX_TEMPERATURE = 40;
    public final static float MIN_TEMPERATURE_HEALTH = 36.2F;
    public final static float MAX_TEMPERATURE_HEALTH = 36.9F;

    public static void main(String[] args) {
        float[] tempArray = generatePatientsTemperatures(30);
//        for (float gg : tempArray) {
//            System.out.println(gg);
//        }
        System.out.println(getReport(tempArray));
    }

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] tempArray = new float[patientsCount];

        for (int i = 0; i < tempArray.length; i++) {
            float randomTemper = 0F;
            while (randomTemper < MIN_TEMPERATURE || randomTemper > MAX_TEMPERATURE) {
                randomTemper = (float) (Math.random() * 10 + MIN_TEMPERATURE);
            }
            tempArray[i] = randomTemper;
        }
        return tempArray;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            String result = String.format("%.3f",value);
        */
        float result = 0;
        int healthPeopleCount = 0;
        StringBuilder builder = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            if (temperatureDatum <= MAX_TEMPERATURE_HEALTH & temperatureDatum >= MIN_TEMPERATURE_HEALTH) {
                healthPeopleCount++;
            }
            String formatData = String.format("%.1f", temperatureDatum);
            builder = builder.append(' ').append(formatData);
            result += temperatureDatum;
        }
        result /= temperatureData.length;
        String formatResult = String.format("%.2f", result);
        String report =
                "Температуры пациентов:" + builder +
                        "\nСредняя температура: " + formatResult +
                        "\nКоличество здоровых: " + healthPeopleCount;

        return report;
    }
}
