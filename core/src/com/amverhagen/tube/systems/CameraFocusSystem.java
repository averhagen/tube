package com.amverhagen.tube.systems;

import com.amverhagen.tube.components.DrawingDimension;
import com.amverhagen.tube.components.CameraFocus;
import com.amverhagen.tube.components.Position;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;

public class CameraFocusSystem extends com.artemis.systems.EntityProcessingSystem {
	@Wire
	ComponentMapper<CameraFocus> cameraMapper;
	@Wire
	ComponentMapper<Position> positionMapper;

	@SuppressWarnings("unchecked")
	public CameraFocusSystem() {
		super(Aspect.all(CameraFocus.class, Position.class, DrawingDimension.class));
	}

	@Override
	protected void process(Entity e) {
		CameraFocus cameraComp = cameraMapper.get(e);
		Position positionComp = positionMapper.get(e);
		cameraComp.camera.position.set(positionComp.x, positionComp.y, 0);
		cameraComp.camera.update();
	}

}
