import YoutubeEmbed from "./YoutubeEmbed";

import "./Adv.css";

function Adv() {
  return (
    <div>
      <div style={{ height: 700 }}>
        <div className="adv-main">
          <p className="adv-title">ErrorShift 영상</p>
          <div className="adv-video">
            <YoutubeEmbed embedId="z3b8cCjDhao" />
          </div>
        </div>
      </div>
    </div>
  );
}
export default Adv;
