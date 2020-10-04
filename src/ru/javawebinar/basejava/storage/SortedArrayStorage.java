package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected Boolean indexIncluded(int index) {
        return index >= 0;
    }

    @Override
    protected int getPosition(int index) {
        return (index < 0) ? -(index + 1) : index;
    }

    @Override
    protected void fillEmptyPosition(int position) {
        for (int i = position; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected void putValue(int position, Resume value) {
        for (int i = size - 1; i >= position; i--) {
            storage[i + 1] = storage[i];
        }
        storage[position] = value;
    }
}
