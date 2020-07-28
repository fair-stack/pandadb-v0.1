package cn.pandadb.oplib.image

import cn.pandadb.commons.semop.ValueSetComparator
import cn.pandadb.oplib.service.ServiceInitializer
import org.neo4j.blob.Blob


class FaceSimilarityComparator extends ValueSetComparator with ServiceInitializer {

  def compareAsSets(blob1: Any, blob2: Any): Array[Array[Double]] = {
    blob1.asInstanceOf[Blob].offerStream(is1=>{
      blob2.asInstanceOf[Blob].offerStream(is2=>{
        val temp = service.computeFaceSimilarity(is1,is2)
        if (temp != null){
          val arr:Array[Array[Double]] = new Array[Array[Double]](temp.size)
          var i:Int = 0
          for(t<-temp){
            arr(i) = t.toArray
            i += 1
          }
          arr
        }
        else{
          null
        }
      })

    })

  }

}