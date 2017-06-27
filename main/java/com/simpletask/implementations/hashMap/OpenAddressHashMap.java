package com.simpletask.implementations.hashMap;

/**
 * TODO
 * Ваши ошибки:
 * ---- Почему не будет работать
 * ! возврат -1L в случае отсутствия элемента
 * ! зацикливается на переполненной таблице при put
 * ! нет поддержки/проверки отрицательных значений ключей
 * <p>
 * ---- Эффективность реализации
 * - использование оберток вместо примитивов
 * - использование Node(несколько массивов будет быстрее и эффективнее по памяти)
 * - не хешируется ключ(вероятность коллизий и вырождение)
 * <p>
 * ---- Замечания по коду
 * - нет возможности создать Map любого размера.
 * - инициализация null`ами в кострукторе не нужна
 * - класс Node должен был быть скрыт(private)
 * - класс Node mutable и переиспользуется, флажок внутри
 * - put возвращает вставленное значение вместо предыдущего
 * - массив node не final и не private
 * <p>
 * ---- Тесты
 * - нет corner case тестов
 * <p>
 * ---- Код
 * название не отображает суть класса
 * форматирование
 * лишний импорт
 */

public class OpenAddressHashMap {
    private static final int TABLE_SIZE = 256;
    private Node[] table;
    private int size;

    public OpenAddressHashMap() {
        table = new Node[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public Long put(Integer key, Long value) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null || table[hash].isDelete()) {
            table[hash] = new Node(key, value);
            size++;
            return table[hash].getValue();
        } else {
            while (table[hash] != null && table[hash].getKey() != key) {
                hash = (hash + 1) % TABLE_SIZE;
            }
            if (table[hash] == null) {
                table[hash] = new Node(key, value);
                size++;
            } else if (table[hash].getKey() == key) {
                table[hash].setValue(value);
            }
            return table[hash].getValue();
        }

    }

    public Long get(Integer key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null || table[hash].isDelete()) {
            return -1L;
        } else {
            return table[hash].getValue();
        }

    }

    public boolean delete(Integer key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] != null) {
            table[hash].setDelete(true);
            size--;
        }
        return table[hash].isDelete();

    }

    public int size() {
        return size;
    }

    static class Node {
        private boolean isDelete;
        private int key;
        private long value;


        public Node(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }


        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public boolean isDelete() {
            return isDelete;
        }

        public void setDelete(boolean delete) {
            isDelete = delete;
        }


    }
}
