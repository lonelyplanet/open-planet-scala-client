package com.lonelyplanet.openplanet.client

import com.lonelyplanet.openplanet.client.apis._

class OpenPlanetAPI(baseUrl: String, apiKey: String)
    extends OpActivities
    with OpAnnotate
    with OpArticles
    with OpAtlas
    with OpImages
    with OpLodgings
    with OpSlugs
    with OpShop {
  val client: OpenPlanetClient = new OpenPlanetClient(baseUrl, apiKey)

}
