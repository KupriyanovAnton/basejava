package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1){
            System.out.println("ERROR: Резюме " + resume.getUuid() + " существует в массиве");
            return;
        }
        if (size == STORAGE_LIMIT) {
            System.out.println("ERROR: Массив заполнен.");
            return;
        }
        storage[size++] = resume;
    }

    public void update(Resume resume){
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("ERROR: Резюме " + resume.getUuid() + " не найдено");
            return;
        }
        storage[index] = resume;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Резюме " + uuid + " не найдено");
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Arrays.copyOfRange(storage, 0, size);
        return Arrays.copyOf(storage, size);
    }
}
