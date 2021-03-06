package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    void deleteResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    void saveResume(int index, Resume resume) {
        storage[size] = resume;
    }
}
