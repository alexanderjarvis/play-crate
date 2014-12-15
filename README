# Play Crate

A Play plugin for the [Crate](https://crate.io) Scala driver, making it really easy to get started with Crate in Play.

## Get started

Add the following dependency to your build.sbt

	"io.crate" %% "play-crate" % "1.0"
	
Add the following to conf/play.plugins (create it if it doesn't exist)

	300:io.crate.client.CratePlugin
	
Add the following to your conf/application.conf to specify the server addresses

	crate.servers = ["localhost:4300"]
	
## Usage

An example:
	
	import io.crate.client.CratePlugin
	
	lazy val client = CratePlugin.client
	
	val request = client.sql("SELECT * FROM sys.nodes").map { response =>
		println("Crate Nodes: " + response.cols.length)
	}
	
	// Blocking for example only
	Await.result(request, 5 seconds)
	

## Building

This project requires SBT to compile.

	$ sbt clean compile
	
## Publishing

Currently you can publish to your local ivy repo to include as a dependency.

	$ sbt publish-local