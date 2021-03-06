public class UnionFind3 implements UF {
	private int[] parent;
	private int[] sz;
	public UnionFind3(int size) {
		parent=new int[size];
		sz=new int[size];
		for(int i=0;i<size;i++) {
			parent[i]=i;
			sz[i]=1;
		}
	}
	@Override
	public int getSize() {
		return parent.length;
	}
	@Override
	public boolean isConnected(int p,int q) {
		return find(p)==find(q);
	}
	private int find(int p) {
		if(p<0||p>=parent.length) {
			throw new IllegalArgumentException("p is out of bound");
		}
		while(p!=parent[p]) {
			p=parent[p];
		}
		return p;
	}
	public void unionElements(int p,int q) {
		int proot=find(p);
		int qroot=find(q);
		if(qroot==proot) {
			return ;
		}
		if(sz[proot]<sz[qroot]) {
			parent[proot]=qroot;
			sz[qroot]+=sz[proot];
		}else {
			parent[qroot]=proot;
			sz[proot]+=sz[qroot];
		}
	}
}
