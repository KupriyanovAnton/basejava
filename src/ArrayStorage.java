import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;


    void clear() {
        size = 0;
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        if (size < 10000) {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        int index = ArrayStorage.getIndex(storage, uuid, size);
        if (index != -1) {
            return storage[index];
        } else {
            return null;
        }

    }

    void delete(String uuid) {
        int index = ArrayStorage.getIndex(storage, uuid, size);
        if (index == -1) return;
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    private static int getIndex(Resume[] storage, String uuid, int size) {
        Resume tmp;
        for (int i = 0; i < size; i++) {
            tmp = storage[i];
            if (tmp.toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size != 0) {
            return Arrays.copyOf(storage, size);
        }
        return new Resume[0];
    }

    int size() {
        return size;
    }
}
