package com.javarush.task.task39.task3911;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        boolean result = false;
        int currentVersion = this.currentVersion;

        Iterator<Map.Entry<Integer, String>> iterator = versionHistoryMap.entrySet().iterator();

        if (versionHistoryMap.containsKey(rollbackVersion))
            try {
                while (iterator.hasNext()){
                    if (iterator.next().getKey() > rollbackVersion)
                        iterator.remove();
                }
                this.currentVersion = rollbackVersion;
                result = true;
            } catch (Exception e) {
                this.currentVersion = currentVersion;
                result = false;
            }

        return result;
    }
}
