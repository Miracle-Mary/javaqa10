package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];

    public void addFilm(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PosterItem[] findAll() {
        return items;
    }

    public PosterItem[] findLast() {
        int resultLength = 5;
        if  (items.length <= 5) {
            resultLength = items.length;
        }
        PosterItem[] result = new PosterItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = items [items.length - 1 - i];
        }
        return result;
    }

    public PosterItem[] findLast(int limit) {
        int resultLength = limit;
        if  (items.length <= limit) {
            resultLength = items.length;
        }
        PosterItem[] result = new PosterItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = items [items.length - 1 - i];
        }
        return result;
    }

}
