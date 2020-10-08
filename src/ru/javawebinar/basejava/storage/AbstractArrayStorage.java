package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (indexIncluded(index)) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
            return;
        }
        if (size == STORAGE_LIMIT) {
            System.out.println("Array is full");
            return;
        }
        saveResume(index, resume);
        size++;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (!indexIncluded(index)) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (!indexIncluded(index)) {
            System.out.println("Resume " + resume.getUuid() + " not exist");
            return;
        }
        saveResume(index, resume);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (!indexIncluded(index)) {
            System.out.println("Resume " + uuid + " not exist");
            return;
        }
        deleteResume(index);
        storage[size - 1] = null;
        size--;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected Boolean indexIncluded(int index) {
        return index >= 0;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void deleteResume(int indexpo);

    protected abstract void saveResume(int index, Resume resume);
}
