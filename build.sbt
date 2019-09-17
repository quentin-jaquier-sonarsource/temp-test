name := "temp-test"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

jacocoReportSettings := JacocoReportSettings()
  .withTitle("Report Title")
  .withFormats(JacocoReportFormats.XML)