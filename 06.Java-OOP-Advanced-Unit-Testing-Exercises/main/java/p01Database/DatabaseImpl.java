package p01Database;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {
    private static final int MAX_ARRAY_CAPACITY = 16;
    private Integer[] numbers;

    public DatabaseImpl(Integer... numbers) throws OperationNotSupportedException {
        this.setNumbers(numbers);
    }

    private void setNumbers(Integer... numbers) throws OperationNotSupportedException {
        if (numbers.length < 1 || 16 < numbers.length){
            throw new OperationNotSupportedException();
        }
        this.numbers = new Integer[MAX_ARRAY_CAPACITY];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i] = numbers[i];
        }
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (number == null || this.getNumbers().length == MAX_ARRAY_CAPACITY){
            throw new OperationNotSupportedException();
        }
        int index = this.getNumbers().length;
        this.numbers[index] = number;
    }

    public void remove() throws OperationNotSupportedException {
        if (this.getNumbers().length == 0){
            throw new OperationNotSupportedException();
        }
        int index = this.getNumbers().length - 1;
        this.numbers[index] = null;
    }

    public Integer[] getNumbers() {
        List<Integer> temp = new ArrayList<Integer>();
        for (Integer number : this.numbers) {
            if (number != null){
                temp.add(number);
            }
        }
        return temp.toArray(new Integer[temp.size()]);
    }
}
