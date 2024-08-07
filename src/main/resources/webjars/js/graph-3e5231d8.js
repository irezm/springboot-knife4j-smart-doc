import{b0 as P,b1 as d,b2 as j,b3 as w,b4 as E,b5 as M,b6 as A,b7 as F,b8 as G,b9 as x,ba as I,bb as V,bc as R,bd as T,be as c,at as C,bf as L}from"./doc-90230dce.js";function U(r,e){return r&&P(r,e,d)}function k(r,e){return function(t,s){if(t==null)return t;if(!j(t))return r(t,s);for(var i=t.length,n=e?i:-1,h=Object(t);(e?n--:++n<i)&&s(h[n],n,h)!==!1;);return t}}var H=k(U);const v=H;function S(r,e,t,s){var i=-1,n=r==null?0:r.length;for(s&&n&&(t=r[++i]);++i<n;)t=e(t,r[i],i,r);return t}function $(r){return typeof r=="function"?r:w}function o(r,e){var t=E(r)?M:v;return t(r,$(e))}function q(r,e){var t=[];return v(r,function(s,i,n){e(s,i,n)&&t.push(s)}),t}function b(r,e){var t=E(r)?A:q;return t(r,F(e))}var z=Object.prototype,B=z.hasOwnProperty;function K(r,e){return r!=null&&B.call(r,e)}function a(r,e){return r!=null&&G(r,e,K)}function Y(r,e){return x(e,function(t){return r[t]})}function p(r){return r==null?[]:Y(r,d(r))}function l(r){return r===void 0}function J(r,e,t,s,i){return i(r,function(n,h,u){t=s?(s=!1,n):e(t,n,h,u)}),t}function Q(r,e,t){var s=E(r)?S:J,i=arguments.length<3;return s(r,F(e),t,i,v)}var W=I(function(r){return V(R(r,1,T,!0))});const X=W;var Z="\0",f="\0",N="";class D{constructor(e={}){this._isDirected=a(e,"directed")?e.directed:!0,this._isMultigraph=a(e,"multigraph")?e.multigraph:!1,this._isCompound=a(e,"compound")?e.compound:!1,this._label=void 0,this._defaultNodeLabelFn=c(void 0),this._defaultEdgeLabelFn=c(void 0),this._nodes={},this._isCompound&&(this._parent={},this._children={},this._children[f]={}),this._in={},this._preds={},this._out={},this._sucs={},this._edgeObjs={},this._edgeLabels={}}isDirected(){return this._isDirected}isMultigraph(){return this._isMultigraph}isCompound(){return this._isCompound}setGraph(e){return this._label=e,this}graph(){return this._label}setDefaultNodeLabel(e){return C(e)||(e=c(e)),this._defaultNodeLabelFn=e,this}nodeCount(){return this._nodeCount}nodes(){return d(this._nodes)}sources(){var e=this;return b(this.nodes(),function(t){return L(e._in[t])})}sinks(){var e=this;return b(this.nodes(),function(t){return L(e._out[t])})}setNodes(e,t){var s=arguments,i=this;return o(e,function(n){s.length>1?i.setNode(n,t):i.setNode(n)}),this}setNode(e,t){return a(this._nodes,e)?(arguments.length>1&&(this._nodes[e]=t),this):(this._nodes[e]=arguments.length>1?t:this._defaultNodeLabelFn(e),this._isCompound&&(this._parent[e]=f,this._children[e]={},this._children[f][e]=!0),this._in[e]={},this._preds[e]={},this._out[e]={},this._sucs[e]={},++this._nodeCount,this)}node(e){return this._nodes[e]}hasNode(e){return a(this._nodes,e)}removeNode(e){var t=this;if(a(this._nodes,e)){var s=function(i){t.removeEdge(t._edgeObjs[i])};delete this._nodes[e],this._isCompound&&(this._removeFromParentsChildList(e),delete this._parent[e],o(this.children(e),function(i){t.setParent(i)}),delete this._children[e]),o(d(this._in[e]),s),delete this._in[e],delete this._preds[e],o(d(this._out[e]),s),delete this._out[e],delete this._sucs[e],--this._nodeCount}return this}setParent(e,t){if(!this._isCompound)throw new Error("Cannot set parent in a non-compound graph");if(l(t))t=f;else{t+="";for(var s=t;!l(s);s=this.parent(s))if(s===e)throw new Error("Setting "+t+" as parent of "+e+" would create a cycle");this.setNode(t)}return this.setNode(e),this._removeFromParentsChildList(e),this._parent[e]=t,this._children[t][e]=!0,this}_removeFromParentsChildList(e){delete this._children[this._parent[e]][e]}parent(e){if(this._isCompound){var t=this._parent[e];if(t!==f)return t}}children(e){if(l(e)&&(e=f),this._isCompound){var t=this._children[e];if(t)return d(t)}else{if(e===f)return this.nodes();if(this.hasNode(e))return[]}}predecessors(e){var t=this._preds[e];if(t)return d(t)}successors(e){var t=this._sucs[e];if(t)return d(t)}neighbors(e){var t=this.predecessors(e);if(t)return X(t,this.successors(e))}isLeaf(e){var t;return this.isDirected()?t=this.successors(e):t=this.neighbors(e),t.length===0}filterNodes(e){var t=new this.constructor({directed:this._isDirected,multigraph:this._isMultigraph,compound:this._isCompound});t.setGraph(this.graph());var s=this;o(this._nodes,function(h,u){e(u)&&t.setNode(u,h)}),o(this._edgeObjs,function(h){t.hasNode(h.v)&&t.hasNode(h.w)&&t.setEdge(h,s.edge(h))});var i={};function n(h){var u=s.parent(h);return u===void 0||t.hasNode(u)?(i[h]=u,u):u in i?i[u]:n(u)}return this._isCompound&&o(t.nodes(),function(h){t.setParent(h,n(h))}),t}setDefaultEdgeLabel(e){return C(e)||(e=c(e)),this._defaultEdgeLabelFn=e,this}edgeCount(){return this._edgeCount}edges(){return p(this._edgeObjs)}setPath(e,t){var s=this,i=arguments;return Q(e,function(n,h){return i.length>1?s.setEdge(n,h,t):s.setEdge(n,h),h}),this}setEdge(){var e,t,s,i,n=!1,h=arguments[0];typeof h=="object"&&h!==null&&"v"in h?(e=h.v,t=h.w,s=h.name,arguments.length===2&&(i=arguments[1],n=!0)):(e=h,t=arguments[1],s=arguments[3],arguments.length>2&&(i=arguments[2],n=!0)),e=""+e,t=""+t,l(s)||(s=""+s);var u=g(this._isDirected,e,t,s);if(a(this._edgeLabels,u))return n&&(this._edgeLabels[u]=i),this;if(!l(s)&&!this._isMultigraph)throw new Error("Cannot set a named edge when isMultigraph = false");this.setNode(e),this.setNode(t),this._edgeLabels[u]=n?i:this._defaultEdgeLabelFn(e,t,s);var _=ee(this._isDirected,e,t,s);return e=_.v,t=_.w,Object.freeze(_),this._edgeObjs[u]=_,O(this._preds[t],e),O(this._sucs[e],t),this._in[t][u]=_,this._out[e][u]=_,this._edgeCount++,this}edge(e,t,s){var i=arguments.length===1?m(this._isDirected,arguments[0]):g(this._isDirected,e,t,s);return this._edgeLabels[i]}hasEdge(e,t,s){var i=arguments.length===1?m(this._isDirected,arguments[0]):g(this._isDirected,e,t,s);return a(this._edgeLabels,i)}removeEdge(e,t,s){var i=arguments.length===1?m(this._isDirected,arguments[0]):g(this._isDirected,e,t,s),n=this._edgeObjs[i];return n&&(e=n.v,t=n.w,delete this._edgeLabels[i],delete this._edgeObjs[i],y(this._preds[t],e),y(this._sucs[e],t),delete this._in[t][i],delete this._out[e][i],this._edgeCount--),this}inEdges(e,t){var s=this._in[e];if(s){var i=p(s);return t?b(i,function(n){return n.v===t}):i}}outEdges(e,t){var s=this._out[e];if(s){var i=p(s);return t?b(i,function(n){return n.w===t}):i}}nodeEdges(e,t){var s=this.inEdges(e,t);if(s)return s.concat(this.outEdges(e,t))}}D.prototype._nodeCount=0;D.prototype._edgeCount=0;function O(r,e){r[e]?r[e]++:r[e]=1}function y(r,e){--r[e]||delete r[e]}function g(r,e,t,s){var i=""+e,n=""+t;if(!r&&i>n){var h=i;i=n,n=h}return i+N+n+N+(l(s)?Z:s)}function ee(r,e,t,s){var i=""+e,n=""+t;if(!r&&i>n){var h=i;i=n,n=h}var u={v:i,w:n};return s&&(u.name=s),u}function m(r,e){return g(r,e.v,e.w,e.name)}export{D as G,U as a,v as b,$ as c,b as d,o as f,a as h,l as i,Q as r,p as v};