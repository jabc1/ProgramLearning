/**
	边的松弛
*/
private void relax(DirectedEdge e){
	int v = e.from();
	int w = e.to();
	if (distTo[w] > distTo[v] + e.weight()){
		distTo[w] = distTo[v] + e.weight();
		edgeTo[w] = e;
	}
}