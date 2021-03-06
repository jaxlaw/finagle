package com.twitter.finagle.zipkin.thrift

import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito
import com.twitter.util.Time

class AnnotationSpec extends SpecificationWithJUnit with Mockito {

  "ZipkinAnnotation" should {
    "serialize properly" in {
      val ann = ZipkinAnnotation(Time.fromSeconds(123), "value", Endpoint(123, 123))
      val tann = ann.toThrift
      tann.isSetHost mustEqual true
      tann.host.ipv4 mustEqual ann.endpoint.ipv4
      tann.host.port mustEqual ann.endpoint.port
      tann.isSetValue mustEqual true
      tann.value mustEqual ann.value
      tann.isSetTimestamp mustEqual true
      tann.timestamp mustEqual ann.timestamp.inMicroseconds
    }
  }
}
