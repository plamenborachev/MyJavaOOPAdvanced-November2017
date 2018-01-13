package p01Database;

import javax.naming.OperationNotSupportedException;

public interface Database {
    void add(Integer number) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    Integer[] getNumbers();
}
