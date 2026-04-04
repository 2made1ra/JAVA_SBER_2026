package lab3.tasks.task8;

import lab3.tasks.task4.Node;

import java.util.NoSuchElementException;

/**
 * Реализация односвязного линейного списка с использованием циклов.
 * <p>
 * <b>Личная заметка (Архитектурное ревью):</b>
 * <br>
 * <b>Какие паттерны и принципы применены:</b>
 * <ul>
 * <li><b>Фабричные методы:</b> Использование статических методов {@code createWithHead} и {@code createWithTail} вместо публичных конструкторов для контроля создания и первичного заполнения списка.</li>
 * <li><b>Принцип DRY (Don't Repeat Yourself):</b> Выделение логики обхода списка в приватные методы-помощники ({@code getNode}, {@code getPreviousNode}, {@code getLastNode}). Это централизовало ось изменений.</li>
 * <li><b>Fail-fast поведение:</b> Выброс стандартных исключений ({@code IndexOutOfBoundsException}, {@code NoSuchElementException}) вместо вывода текста в консоль, что делает класс пригодным для использования в реальной бизнес-логике.</li>
 * <li><b>Инкапсуляция состояния:</b> Поле {@code length} закрыто от внешнего вмешательства и самостоятельно поддерживается в актуальном состоянии при любых мутациях списка.</li>
 * </ul>
 * <p>
 * <b>Что можно улучшить (TODO на будущее):</b>
 * <ul>
 * <li><b>Указатель на хвост (Tail Pointer):</b> Добавить поле {@code private Node tail}. Сейчас метод {@code addLast} перебирает весь список (сложность O(n)). С указателем на хвост вставка в конец станет мгновенной (сложность O(1)).</li>
 * <li><b>Обобщения (Generics):</b> Заменить жесткую привязку к {@code int} (в классе {@code Node}) на дженерики (например, {@code Node<T>}), чтобы список мог хранить любые типы данных (строки, объекты).</li>
 * <li><b>Интерфейс Iterable:</b> Реализовать стандартный интерфейс {@code java.lang.Iterable}, чтобы по списку можно было удобно проходить циклом {@code for (int val : list)}.</li>
 * <li><b>Общий интерфейс:</b> Выделить общий Java-интерфейс (например, {@code CustomLinkedList}) для этой итеративной и будущей рекурсивной реализаций, чтобы соответствовать принципу инверсии зависимостей (SOLID).</li>
 * </ul>
 */
public class IterativeLinkedList {
    private Node head;
    private int length;

    private IterativeLinkedList(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Длина списка не может быть отрицательной");
        }

        this.length = length;
        this.head = null;
    }

    public static IterativeLinkedList createWithHead(int length) {
        IterativeLinkedList list = new IterativeLinkedList(length);
        list.createHead();
        return list;
    }

    public static IterativeLinkedList createWithTail(int length) {
        IterativeLinkedList list = new IterativeLinkedList(length);
        list.createTail();
        return list;
    }

    public int getLength() {
        return this.length;
    }

    // Ввод с головы - создание голов, справа налево?
    private void createHead() {
        for (int i = length - 1; i >= 0; i--) {
            head = new Node(i, head);
        }
    }

    // Ввод с хвоста - создание хвостов, слева направо?
    private void createTail() {
        if (length == 0) {
            return;
        }

        head = new Node(0, null);
        Node currentNode = head;

        for (int i = 1; i < length; i++) {
            currentNode.next = new Node(i, null);
            currentNode = currentNode.next;
        }
    }

    @Override
    public String toString() {
        Node ref = head;
        StringBuilder stringList = new StringBuilder();
        while (ref != null) {
            stringList.append(ref.value);

            if (ref.next == null) {
                break;
            }

            stringList.append(", ");
            ref = ref.next;
        }
        return stringList.toString();
    }

    // Метод для поиска указателя на нужный элемент списка
    private Node getNode(int index) {
        Node ref = head;
        for (int i = 0; i < index; i++) {
            ref = ref.next;
        }
        return ref;
    }

    private Node getPreviousNode(int index) {
        return getNode(index - 1);
    }

    // Интересно, правильная реализация включает в себя хранения указателя на хвост списка
    // на уровне поля экземпляра - реализовать на будущее
    private Node getLastNode() {
        return getNode(length - 1);
    }

    public void addFirst(int value) {
        head = new Node(value, head);
        length++;
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node lastNode = getLastNode();
            lastNode.next = new Node(value, null);
        }
        length++;
    }

    public void insert(int insertIndex, int value) {
        if (insertIndex < 0 || insertIndex > length) {
            throw new IndexOutOfBoundsException("Индекс вне границ: " + insertIndex);
        }

        if (insertIndex == 0) {
            this.addFirst(value);
            return;
        }

        Node ref = getPreviousNode(insertIndex);
        ref.next = new Node(value, ref.next);
        length++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }
        head = head.next;
        length--;
    }

    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }

        if (head.next == null) {
            head = null;
        } else {
            Node ref = getPreviousNode(length - 1);
            ref.next = null;
        }
        length--;
    }

    public void remove(int deleteIndex) {
        if (deleteIndex < 0 || deleteIndex >= length) {
            throw new IndexOutOfBoundsException("Некорретный индекс удаления: " + deleteIndex);
        }

        if (deleteIndex == 0) {
            removeFirst();
            return;
        }

        Node ref = getPreviousNode(deleteIndex);
        ref.next = ref.next.next;
        length--;
    }
}
