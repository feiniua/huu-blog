<template>
  <div id="star">
    <div class="wrapper">
      <div class="stars">
        <div v-for="(item, index) in starCount" :key="index" class="star" ref="star"></div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Star",
    data() {
      return {
        starCount: 800,
        distance: 800
      }
    },
    mounted() {
      let _this = this;
      let starArr = _this.$refs.star;
      starArr.forEach(item => {
        let speed = 0.5 + (Math.random());
        let thisDistance = _this.distance + (Math.random() * 300);
        item.style.transformOrigin = `0 0 ${thisDistance}px`;
        item.style.transform = `translate3d(0,0,-${thisDistance}px) rotateY(${(Math.random() * 180)}deg) rotateX(${(Math.random() * -360)}deg) scale(${speed}, ${speed})`;
      })
    }
  }
</script>

<style scoped>
  .wrapper {
    position: fixed;
    width: 100%;
    height: 800px;
    background: radial-gradient(220% 105% at top center, #0a111d 10%, #1b2947 40%, #75517d 65%, #c06070) fixed;
  }

  .stars {
    transform: perspective(500px);
    transform-style: preserve-3d;
    position: absolute;
    perspective-origin: 50% 100%;
    left: 50%;
    animation: rotate 90s infinite linear;
  }
  @keyframes rotate {
    0% {
      transform: perspective(400px) rotateZ(20deg) rotateX(-40deg) rotate(0);
    }
    100% {
      transform: perspective(400px) rotateZ(20deg) rotateX(-40deg) rotate(-360deg);
    }
  }
  .star {
    width: 2px;
    height: 2px;
    background: #f7f7b6;
    position: absolute;
    top: 0;
    left: 0;
    backface-visibility: hidden;
  }
</style>
