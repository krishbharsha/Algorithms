#!/usr/local/bin/jython27 --

import json
import sys


class LoadSchema(object):
    def __init__(self):
        self.hivePreviousRecordsStageTableName = ""
        self.processedLogsTableName = ""
        self.columnList = ""
        self.hbaseKey = ""
        self.hbaseTableName = ""
        self.rawLogsTableName = ""
        self.hivePartitionedStageTableName = ""
        self.tableName = ""
        self.schemaData = ""

    def getHivePreviousRecordsStageTableName(self):
        return self.hivePreviousRecordsStageTableName

    def getProcessedLogsTableName(self):
        return self.processedLogsTableName

    def getColumnList(self):
        return self.columnList
