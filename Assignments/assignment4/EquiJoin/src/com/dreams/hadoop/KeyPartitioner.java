package com.dreams.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class KeyPartitioner extends Partitioner<CustomKey, Text> {

	@Override
	public int getPartition(CustomKey key, Text value, int numPartitions) {
		return (key.getStoreId().hashCode() & Integer.MAX_VALUE) % numPartitions;
	}

}
