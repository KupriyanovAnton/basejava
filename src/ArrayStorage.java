import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        if (size > 0) {
            Arrays.fill(storage, 0, size - 1, null);
            size = 0;
        }
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        int index = this.getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    void delete(String uuid) {
        int index = this.getIndex(uuid);
        if (index == -1) return;
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    private int getIndex(String uuid) {
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
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
