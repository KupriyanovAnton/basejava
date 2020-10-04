package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Boolean indexIncluded(int index) {
        return index != -1;
    }

    @Override
    protected int getPosition(int index) {
        return (index == -1) ? size : index;
    }

    @Override
    protected void fillEmptyPosition(int position) {
        storage[position] = storage[size - 1];
    }

    @Override
    protected void putValue(int position, Resume value) {
        storage[position] = value;
    }
}
